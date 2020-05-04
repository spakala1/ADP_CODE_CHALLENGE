Feature: Auto trader web page.

  Scenario: ADP problem solving
    When I login to Auto trader web page
    Then I verify "Browse by Make" is displayed on Auto Trader page
    And  I verify "Browse by Style" is displayed on Auto Trader page
    And  I verify "Advanced Search" is displayed on Auto Trader page
    And  I verify "Search Button" is displayed on Auto Trader page
    When I click on "Advanced Search" Auto Trader page
    Then I verify "Location" is displayed on Auto Trader page
    When I enter "30004" in "Zip Code" field on  Auto Trader page
    And  I click on "Certified Check Box" Auto Trader page
    And  I click on "Convertible Check Box" Auto Trader page
    And  I select "2017" in "From" drop down on  Auto Trader page
    And  I select "2020" in "To" drop down on  Auto Trader page
    And  I select "BMW" in "Vehicle 1" drop down on  Auto Trader page
    And  I click on "Search" Auto Trader page
    Then I verify only BMW cars are visible on the Auto trader page