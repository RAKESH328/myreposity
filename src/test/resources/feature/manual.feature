Feature: Gmail mail compose

  Scenario Outline: 
    Given open "chrome" browser
    And lunch the site using "http://www.gmail.com"
    When do login with using "pnrsir258" and "8500692837"
    Then Compose is displayed
    When click on compose
    When filed fill with "<to>","<sub>","<body>","<attach>"
    When send is enabled
    Then click on send
    Then "Message sent" should be displayed
    When do logout
    Then login page should displayed
    When do close site

    Examples: 
      | to                            | sub    | body              | attach                                                                 |
      | gajularakeshkumar94@gmail.com | resume | hi sending        | D:\\rakesh\\rakesh resume.doc                                          |
      | vyshalipatel0930@gmail.com    | resume | this send by auto | D:\\rakesh\\rakesh resume.doc                                          |
      | grakeshkumar095@gmail.com     | itsme  | hi raaaa          | C:\\Users\\markb\\OneDrive\\Pictures\\Screenshots\\Screenshot (10).png |
