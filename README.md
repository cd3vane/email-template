# E-Mail Template Form

## Overview
Written alongside reading Test-Driven Development by Lasse Koskela. Template accepts a String with any number of variables denoted by `${variable}` with the value that you provide. Example: template "Dear, ${name}" along with setting the name variable to "Charles" would yield the output "Dear, Charles". This excercise taught me a lot about test first principles and why they are so important. Having a full test suite that you can always run your code against allows for refactoring without fear because you are always only minutes from a passable state that you can revert to. 

## Test Situations
- Variables that are missing values throw custom MissingValueException
- Setting a variables value to a String that looks like a variable is handled by only performing one pass on the template
