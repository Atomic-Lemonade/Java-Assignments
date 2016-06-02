# Java-Basic-Computation-Assignment
Written for a warm-up assignment, this program takes a user-input decimal number that represents an amount of money in US dollars and cents and outputs the maximum amount of dollars and change equal to the currency amount that was input.

[ HOW TO USE ]

Only enter currency when prompted by the text "Enter currency: ".

Currency must:
  - Be in US dollars and cents
  - Be a positive number
  - Must be written numerically
    (Ex. Write 500.12, not "five hundred dollars and twelve cents")
  - Must not include the dollar sign ($)
    (Ex. Write 43.29, not $43.29)

Currency with cents that go beyond two decimal places will be truncated
(not rounded) to two decimal places.

(Ex. 24.9999 becomes 24.99)

There is no maximum limit to the currency amount, but it is advisable to
use amounts that are manageable in regular transactions to prevent the program from
crashing or losing formatting.
