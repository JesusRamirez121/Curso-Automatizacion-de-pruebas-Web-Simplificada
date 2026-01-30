Feature: Registration

  Scenario Outline: Successful registration
    Given Pepito wants to sign up in the application
    When Pepito sends the required information to sign up
      | nombres   | apellidos   | edad   | pais   | sexo   | email   | dia   | foto   |
      | <nombres> | <apellidos> | <edad> | <pais> | <sexo> | <email> | <dia> | <foto> |
    Then Pepito should have a new account created
      | nombres   | apellidos   | edad   | pais   | sexo   | email   | dia   |
      | <nombres> | <apellidos> | <edad> | <pais> | <sexo> | <email> | <dia> |

    Examples:
      | nombres  | apellidos | edad | pais     | sexo | email          | dia     | foto               |
      | Jesus    | Garcia    | 30   | Colombia | M    | prueba@jrc.co  | Lunes   | pictures/gokuM.jpg |
      #| Kakarota | Garcia    | 30   | Colombia | F    | prueba1@jrc.co | Viernes | pictures/gokuF.jpg |


  Scenario: Missing required fields for registration
    Given Pepito wants to sign up in the application
    When Pepito does not send the required information
    Then Pepito should be told all fields are required
