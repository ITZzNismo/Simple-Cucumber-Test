Feature: googleTest
  Scenario: Find kitten images on Google
		Given we can open google 
		When we search for kittens 
		Then google will return us images of kittens