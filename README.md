# BITS-OpenSource-Assignment

## Project Goals

1. Create a main repository and the contributors have to create a fork of the repository.
2. Create a README file and include contributions from all the members of the group.
3. Create a Github Page and include contributions from all the members of the group.
4. Add software code in the repository and include contributions from all members of the group.

## Project Tech Stack

### Backend Framework

	| Spring Boot | 3.0.0-SNAPSHOT |

### Database

    | H2 Database | 2.1.212 |

### ORM Version

    | Spring Data JPA | 3.0.0-SNAPSHOT |
    | Spring Framework ORM | 6.0.0-SNAPSHOT |

## Project Data Models

## Database Entity

```
@Entity
@Table(name = "countries")
@Data
public class Countries {

    @Id
    private Long id;

    private String name;
}
```

## Network Entity

```
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {
    private Meta meta;
    private List<String> data;
}

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Meta {
    private String errorCode;
    private String errorMessage;
}


```

## Project Version
```
0.0.1
```

