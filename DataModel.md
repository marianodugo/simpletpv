# DataModel #

| **ARTICULO**|| | |
|:|:|:|:|
|ART\_ID|LONG|PK, FK ARTICULO\_PAD, TICKET\_LINEAS|Identificador del artículo|
|ART\_DESCRIPCION|VARCHAR(256)||Descripcion del articulo|
|ART\_ETIQUETA|VARCHAR(256)||El texto que se va a mostrar en el formulario.|
|ART\_SEC|VARCHAR(256)|||
|ART\_PRECIO|INT||Precio del articulo|
|ART\_TIPO|VARCHAR(64)||Tipo de servicio|
|ART\_FACT|VARCHAR(64)|||
|ART\_MOVIMIENTO|DATETIME||Fecha de un movimiento del articulo|

| **ARTICULO\_PAD**|| | |
|:|:|:|:|
|ART\_ID|LONG|PK, FK ARTICULO|Identificador del artículo|
|ART\_DESCRIPCION|VARCHAR(256)||Descripcion del articulo|
|ART\_ETIQUETA|VARCHAR(256)||El texto que se va a mostrar en el formulario.|
|ART\_SEC|VARCHAR(256)|||
|ART\_PRECIO|INT||Precio del articulo|
|ART\_TIPO|VARCHAR(64)||Tipo de servicio|
|ART\_FACT|VARCHAR(64)|||
|ART\_MOVIMIENTO|DATETIME|PK|Fecha de un movimiento del articulo|

| **CAJERA**|| | |
|:|:|:|:|
|CAJ\_ID|LONG|PK, FK TICKET|Identificador de cajera|
|CAJ\_NOMBRE|VARCHAR(256)||Nombre de cajera|
|CAJ\_AUT|VARCHAR(64)|||

| **EMPRESA**|| | |
|:|:|:|:|
|EMP\_ID|LONG|PK, FK TICKET|Identificador de empresa|
|EMP\_NOMBRE|VARCHAR(64)||Identificador de empresa|
|EMP\_DESCRIPCION|VARCHAR(256)||Descripcion de la empresa|

| **PAGO**|| | |
|:|:|:|:|
|PAG\_ID|LONG|PK, FK TICKET|Identificador de pago|
|PAG\_DESCRIPCION|VARCHAR(256)||Descripcion del pago|
|PAG\_FAC\_SER|VARCHAR(1)||N/P/C|
|PAG\_DESC\_TIC|VARCHAR(64)||Texto que aparecerá en el ticket|

| **PARAMETROS**|| | |
|:|:|:|:|
|PAR\_NOMBRE|VARCHAR(32)|PK|Nombre del parámetro|
|PAR\_VALOR|VARCHAR(32)||Valor del parámetro|
|PAR\_DESCRIPCION|VARCHAR(64)||Descripción del parámetro|

| **PREFERENCIAS**|| | |
|:|:|:|:|
|PRE\_USUARIO|VARCHAR(64)|PK, FK USUARIOS|Usuario que se le aplica las preferencias|
|PRE\_NOMBRE|VARCHAR(64)|PK|Nombre de la preferencia|
|PRE\_VALOR|VARCHAR(64)||Valor de la preferencia|
|PRE\_DESCRIPCION|VARCHAR(256)||Descripcion de la preferencia|

| **TICKET**|| | |
|:|:|:|:|
|TIC\_ID|LONG|PK AUTOINCREMENT, FK TICKET\_LINEAS|Identificador unico del ticket.|
|TIC\_EMPRESA|VARCHAR(2)|FK EMPRESA|Numero de empresa (las dos primeras cifras de la tarjeta)|
|TIC\_EMPLEADO|VARCHAR(5)||Numero de empleado (las ultimas cifras de la tarjeta)|
|TIC\_CAJERA|LONG||Numero de cajera|
|TIC\_FECHA|DATE||Fecha en la que se ha hecho la venta|
|TIC\_HORA|TIME||Hora de la venta|
|TIC\_ARTICULO|LONG||Tipo de articulo que se vende (menu completo, primer/segundo plato, etc...)|
|TIC\_PAGO|LONG|FK PAGO|Tipo de pago (tarjeta empresa, efectivo, visa, etc...)|
|TIC\_IMPORTE|INT||Importe a pagar|
|TIC\_SERVICIO|LONG||Tipo de servicio (almuerzo, comida, etc...)|
|TIC\_USUARIO|VARCHAR(64)|FK USUARIOS|Usuario que entra en el sistema|

| **TICKET\_LINEAS**|| | |
|:|:|:|:|
|LTI\_TICKET|LONG|PK, FK TICKET|Número del ticket|
|LTI\_LINEA|INT|PK|Número de línea del articulo|
|LTI\_ARTICULO|LONG|FK ARTICULO|Articulo|
|LTI\_CANTIDAD|INT||Cantidad de articulos|
|LTI\_IMPORTE|INT||Importe a pagar|

| **USUARIOS**|| | |
|:|:|:|:|
|USR\_USUARIO|VARCHAR(64)|PK, FK TICKET, PREFERENCIAS, USUARIOS\_HIST|Login del usuario|
|USR\_PASSWORD|VARCHAR(64)||Password del usuario|
|USR\_DESCRIPCION|VARCHAR(128)||Descripcion del usuario|
|USR\_NOMBRE|VARCHAR(64)||Nombre del usuario|
|USR\_LAST\_LOGIN|DATETIME||Ultima entrada en el sistema|
|USR\_GRUPO|VARCHAR(64)||Grupo al que pertenece el usuario|

| **USUARIOS\_HIST**|| | |
|:|:|:|:|
|UHT\_USUARIO|VARCHAR(64)|PK, FK USUARIOS|Nombre del usuario|
|UHT\_TIPO|VARCHAR(32)||Evento del historial|
|UHT\_DESCRIPCION|VARCHAR(128)||Descripcion del evento del historial|
|UHT\_MOVIMIENTO|DATETIME|PK|Fecha del historial|
|UHT\_LAST\_LOGIN|DATETIME||Ultima entrada en el sistema|



