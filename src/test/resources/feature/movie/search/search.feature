Feature: Search movie

    Scenario: User calls web service to search a movie by its title
        Given the movie with title is "Iron Man"
        When I get the movie
        Then status code is 200
        And actor is a string
        And year is a integer
        And ratings is a array

    Scenario: User calls web service to search a movie by title and year
        Given the movie with title is "Avengers"
        And the movie year is 2019
        When I get the movie
        Then status code is 200
        And ratings is array with size 2

    Scenario: User calls web service to search a movie by title and year and not found movie
        Given the movie with title is "Avengers"
        And the movie year is 2021
        When I get the movie
        Then status code is 200
        And movie not found