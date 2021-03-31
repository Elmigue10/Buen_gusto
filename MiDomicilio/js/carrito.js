let productosContainer = document.getElementById("productos")

let productos = []


const getProductos = () => {
    // axios.get('https://reqres.in/api/users')
    axios.get('http://localhost:18090/api/v1/carritoCompras')
    .then(response => {
        const respuestaProductos = response.data;
        console.log(`GET respuestaProductos`, respuestaProductos);
        productos = respuestaProductos
        render();
        //let buttonCarrito = document.getElementById("buttonCarrito");
    })
     .catch(error => console.error(error));
    };
getProductos();

function render () {
    const productosRender = productos.map((producto)=>{
        return `<ul><div class="productosContainer">
        <div class="imagenContainer">    
            <img src="../public/img/logo.png"></img>
        </div>
        <div class="contentContainer">
            <li class="nombreProducto">${producto.nombre}</li>
            <li class"descripcionProducto">${producto.descripcion}</li>
            <li class="precioProducto">$${producto.precio}</li>
            <li class="cantidadProducto">${producto.cantidad}</li>
            <button class="btn btn-outline-success" id="buttonEliminar">Eliminar<span class="icon-bin"></span></button>
        <div>
        </div></ul>`
    }).join("")
    productosContainer.innerHTML = productosRender
    // agregarCarrito()
}