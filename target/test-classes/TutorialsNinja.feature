Feature: Verify the Tutorials Ninja Home page

Background: 
Given The user should be on the Tutorial Ninja Home Page
Then the title of webPage should contains the text "Your Store"

Scenario: Verify the add to cart functionality of the Mackbook product
When the user click on mackbook product available on the page
Then the title of the web page should contains "MacBook"
And verifies the Add to cart text should contains "0 item(s) - $0.00"
When the user add the quantity as "1"
And click on the add to cart button
Then then the add to cart text should contains "  1 item(s) - $602.00"

Scenario: Verify the add to cart functionality of the Mackbook product
When the user click on mackbook product available on the page
Then the title of the web page should contains "MacBook"
And verifies the Add to cart text should contains "0 item(s) - $0.00"
When the user add the quantity as "1"
And click on the add to cart button
Then then the add to cart text should contains "  1 item(s) - $602.00"

Scenario: Verify the add to cart functionality of the Mackbook product
When the user click on mackbook product available on the page
Then the title of the web page should contains "MacBook"
And verifies the Add to cart text should contains "0 item(s) - $0.00"
When the user add the quantity as "1"
And click on the add to cart button
Then then the add to cart text should contains "  1 item(s) - $602.00"

Scenario: Verify the add to cart functionality of the Mackbook product
When the user click on mackbook product available on the page
Then the title of the web page should contains "MacBook"
And verifies the Add to cart text should contains "0 item(s) - $0.00"
When the user add the quantity as "1"
And click on the add to cart button
Then then the add to cart text should contains "  1 item(s) - $602.00"