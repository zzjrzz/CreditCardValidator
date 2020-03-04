# Credit Card Validator

This repository is a sample of a credit card validator written in Kotlin.

## Thoughts and decision-making process
- First thing after reading the problem is to establish a comprehensive test suite.
- Break down the problem into checking for length, starting number and luhn algorithm.
- Should have classes that allow extending to new rules and keep to SOLID principles. Created rule interface that is first used for the length rule
- Used the length rule in an Amex rule.       
- Instead of making a rule for each card, have a generic one that takes in allowed lengths, allowed start values and the enum for those combinations.
    
## Any issues you ran into
- IDE messing up my gradle file :(
                                    
## Any assumptions you made
- Build file is needed to have consistent rules for compilation (used Gradle)
- Do not need to create API for a simple problem
                                    
## Anything else you feel is relevant & would add further value
- Should align the test to more practical daily task of a developer, less 
mathematics and more emphasis on maintainability, test driven development.