Feature: I can find a city insisde a state

@List
Scenario Outline: As a Test Engineer, I want to validate that a text is present inside the list.
    Given I navigate to the list page
    When  I search <state> in the list
    Then I can find <city> in the list

Examples:
    | state      | city             | 
    | Washintong |Seatle, Washintong| 
    | Chicago    |Chicago, Illinois |