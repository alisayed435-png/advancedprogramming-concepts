### Assignment: Exploring the Java Stream API

#### Introduction
This assignment covers the basics of the Java 8 Stream API. Streams are a functional programming concept and, while Java is not primarily a functional language, the Stream API brings functional-style data processing to Java. Streams are powerful when working with collections and can significantly improve code readability by focusing on data pipelines rather than traditional iteration loops.

#### Scenario
You are working for a movie search and recommendation platform that fetches data about movies from an external API. The platform needs tools to process and analyze this data efficiently using the Java Stream API. Your task is to implement several features for the platform using both finite and infinite streams.

---

### Task 1: Finite Stream for Movies

#### Subtasks:
1. **streamFiniteSearch:**
    - Use the provided `MovieProcessor` class to fetch a list of movies.
    - Each movie has the following attributes: `Title`, `Year`, `ImdbID`, and `type`. Type only exists because the DB also holds some series and games
    - Display the fetched movies in the console.

2. **Filter Movies:**
    - Implement options to filter movies by:
        - A specific genre.
        - Release year range, for simplicity we use newer than x.

    

#### Requirements:
- Use finite streams to process and filter movie data.
- Use appropriate stream operations.

---

### Task 2: Infinite Stream for Movie Recommendations
Your platform wants to offer a "Surprise Me" feature that continuously recommends random movies to the user until they choose to stop.

#### Subtasks:
1. **Generate Random Movie Suggestions:**
    - Create an infinite stream of random movies using the `Stream.generate()` method.
    - Each suggested movie should be displayed like searched movies.

2. **Limit Recommendations:**
    - Allow the user to re-roll the recommendation: you get one recommendation at a time and when the user wants another one you fetch the next one.
    - Remember: we all together share 10000 API calls a day, so we want to minimize the amount of calls we make.



#### Requirements:
- Use an infinite stream for generating random movie recommendations.
- Ensure that the program can handle user input gracefully.
- Minimize API calls by waiting for user confirmation after each recommendation.

---

---
### Task 3: Build a CLI for Movie Analytics
You need to build a command-line interface (CLI) 

This contains the following options:
1. Search for movies
2. Search with a year filter
3. Get a random movie recommendation, is a loop that continues one by one until the user decides to stop
4. Toggle: Switch between mock and real world data, not something you would see in the real world, but we're limited to 10000 calls a day, while the mock data is unlimited. I wanted to show you real data for real world applications, but we have a fallback mock
5. Help, prints out the options
6. Exit


---


### Task 4: Unit Tests
You are provided with a set of unit tests to validate the functionality of your methods. Your goal is to implement the required methods and tests so that all tests pass successfully. Some methods are fully implemented, while others require your input.

#### Subtasks:
1. **Complete the Tests:**
    - The test cases will cover:
        - Fetching and displaying movie data.
        - Filtering functionality.
        - Testing the stream, there is a difference between our fetch and the stream
        - Generating random movie recommendations.

2. **Run the Tests:**
    - Use JUnit to execute the tests.
    - Ensure all tests pass
 

### Provided Resources
1. **Movie Processor Class:**
    - There are a few important methods in here, look around, but these are the ones you will need, also this wraps the api-connector to not use it directly.:
      - fetchMovies: gets a list of movies from our  API connector.
      - fetchRecommendation: gets a random movie recommendation from the API connector.
      - fetchMoviesFromMock: returns a list of movies from our mockAPI.
      - fetchRecommendationsFromMock: returns a random movie recommendation from our mockAPI.
    

