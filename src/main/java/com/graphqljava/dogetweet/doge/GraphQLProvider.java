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

	privvate GraphQLSchema buildSchema(String sdl) {

	}
}
