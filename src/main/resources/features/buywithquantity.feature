Feature: Buy with Quantity
  As a owner
  I can know all quantity left

Background:
  Given a product Bread with price 20.50 exists and quantity 10
  And a product Jam with price 80.00 exists and quantity 5

Scenario: Buy one product
  When I buy Bread with quantity 1
  Then a product Bread quantity left 9
  Then total should be 20.50

Scenario: Buy more than quantity product
  When I buy Jam with quantity 6
  Then I can not buy Jam ,a product have quantity 5

Scenario: Buy two product at the same time
  When I buy Bread with quantity 2
  And I buy Jam with quantity 5
  Then a product Bread left 8 and Jam left 0
  Then total should be 441.00

 Scenario: Buy two product at difference time
   When I buy Bread with quantity 3
   Then a product Bread quantity left 7
   When I buy Bread with quantity 1
   Then a product Bread quantity left 6
   Then total should be 82.00