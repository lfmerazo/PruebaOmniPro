Feature: Funcionalidades en CuraHealtCare
  Rule: Yo como usuario quiero iniciar sesión en CURA Healthcare Service
  con el fin de poder agendar una cita medica.

    Background: Ingresar a la web
      Given que el usuario ingresa a la web CURA Healthcare Service

    @login-exitoso
    Scenario Outline: Validar que inicie sesión de manera correcta
      When ingreso el usuario <username> y contrasenia <password> correctos
      Then inicia sesion de manera exitosa
      Examples: [HAPPY PATH]
        |username |password          |
        |John Doe |ThisIsNotAPassword|


    @login-no-exitoso
    Scenario Outline: Validar que no inicie sesión
      When ingreso el usuario <username> y contrasenia <password> incorrectos
      Then el sistema no inicia sesion
      Examples: [UNHAPPY PATH]
        |username |password         |
        |John Doe |ThisIsNotAPassword1|


    @cita-exitosa
    Scenario Outline: Validar que se agende mi cita
      When ingreso el usuario <username> y contrasenia <password> correctos
      And diligencio la solicitud de cita <facility>, <readmision>, <Healthcare>, <visitDate> y <comment>
      Then se agenda la cita de manera exitosa con los datos registrados <facility>, <readmision>, <Healthcare>, <visitDate> y <comment>
      Examples: [HAPPY PATH]
        |username |password          |facility                        |readmision |Healthcare |visitDate  |comment                    |
        |John Doe |ThisIsNotAPassword|Hongkong CURA Healthcare Center |Yes        |Medicaid   |28/04/2023 |cita médica taller final QA|

    @cita-historial
    Scenario Outline: Validar cita en historial
      When ingreso el usuario <username> y contrasenia <password> correctos
      And diligencio la solicitud de cita con fecha <visitDate>
      And ingreso al historial de citas
      Then se visualiza mi fecha <visitDate> de cita en el historial
      Examples: [HAPPY PATH]
        |username |password          |visitDate |
        |John Doe |ThisIsNotAPassword|29/04/2023|

    @pagina-profile
    Scenario Outline: Validar ingreso página Profile
      When ingreso el usuario <username> y contrasenia <password> correctos
      And selecciono el tab Profile
      Then se visualiza la página Profile con título <titleProfilePage>
      Examples: [HAPPY PATH]
        |username |password          |titleProfilePage|
        |John Doe |ThisIsNotAPassword|Profile         |

