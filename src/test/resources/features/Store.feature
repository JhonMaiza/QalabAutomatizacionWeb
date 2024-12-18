#language: es
Característica: Product - Store

  @validarPrecioProducto
  Esquema del escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "<usuario>" y clave "<clave>" y se valida la autenticación con el "<nombre>"
    Cuando navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    Y agrego "<unidades>" unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total calculado correctamente sea "<monto>"
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito sea "<monto>"

    Ejemplos:
      | usuario               | clave          | nombre     | categoria | subcategoria | unidades | monto    |
      | jhonmaiza@outlook.com | Qalab2024*     | Jhon Maiza | Clothes   | Men          | 2        | S/ 38.24 |
      | usuario@invalido1.com | clave_invalida | Jhon Maiza | Clothes   | Men          | 3        | S/ 57.72 |
      | jhonmaiza@outlook.com | Qalab2024*     | Jhon Maiza | Autos     | NA           | 4        | S/ 76.96 |