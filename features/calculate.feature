Feature: Calculate borrow power
  	
	@Sanity @P1 
  Scenario Outline: Borrow Power Calculate
    Given calculate page loads properly
    When Select <ApplicationType> and select <NumberOfDependants> and select <PropertyYouWouldLikeToBuy>
    And input <YourIncome> and input <YourOtherIncome>
    And input <LivingExpenses> and input <CurrentHomeLoanRepayments> and input <OtherLoanRepayments> 
    And input OtherCommitments<OtherCommitments> 
    And input TotalCreditCardLimits<TotalCreditCardLimits>
    And press WorkOut button
    Then <BorrowEstimation> should display
    And StartOver button avaliable
    And WorkOut button invisible
    When I click StartOver button
    Then all fields cleared
    And Workout button is avaliable
    And StartOver button invisible
  
    Examples: 
    	|ApplicationType|NumberOfDependants|PropertyYouWouldLikeToBuy|YourIncome|YourOtherIncome|LivingExpenses|CurrentHomeLoanRepayments|OtherLoanRepayments|OtherCommitments|TotalCreditCardLimits|BorrowEstimation|     
   		| Single  			|        0         |     Home to live in     |  80000   |     10000     |     500      |            0            |        100        |       0        |       10000         |    500000		   |

  
  
   