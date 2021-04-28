@Component
public class GraphQLProvider {
	private GraphQL graphQL;

	@Bean
	public GraphQL graphql() {
		return graphql;
	}

	@PostContruct
	public void init() throws IOException {
		URL url = Resources.getResource("schema.graphql");
		String sdl = Resources.toString(url, Charsets.UTF_8);
		GraphQLSchema graphQLSchema = buildSchema(sdl);
		this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	}

	@Autowired
	GraphQLDataFetchers graphQLDataFetchers;

	private GraphQLSchema buildSchema(String sdl) {
		TypeDefinitionRegistry = new SchemaParser().parse(sdl);
		RuntimeWiring runtimeWiring = buildWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
	}

	private RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
			.type(newTypeWiring("Query")
					.dataFetcher("latestTweets", graphQLDataFetchers.getLatestTweetsFetcher()))
			.type(newTypeWiring("Query")
					.dataFetcher("timeSince", graphQLDataFetchers.getTimeSinceFetcher()))
			.build();
	}
}
