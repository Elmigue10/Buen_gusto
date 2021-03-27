let productosContainer = document.getElementById("productos")

let productos = []


const getProductos = () => {
    // axios.get('https://reqres.in/api/users')
    axios.get('http://localhost:18090/api/v1/producto')
    .then(response => {
        const respuestaProductos = response.data;
        console.log(`GET respuestaProductos`, respuestaProductos);
        productos = respuestaProductos
        render();
    })
     .catch(error => console.error(error));
    };
getProductos();

function render () {
    const productosRender = productos.map((producto)=>{
        return `<ul><div class="productosContainer">
        <div class="imagenContainer">    
            <img src="./public/img/logo.png"></img>
        </div>
        <div class="contentContainer">
            <li class="nombreProducto">${producto.nombre}</li>
            <li class"descripcionProducto">${producto.descripcion}</li>
            <li class="precioProducto">$${producto.precio}</li>
            <button class="btn btn-outline-success" id="buttonCarrito">Agregar <span class="icon-cart"></span></button>
        <div>
        </div></ul>`
    }).join("")
    productosContainer.innerHTML = productosRender
    // agregarCarrito()
}

let carritoProductos = []

// async function agregarCarrito() {
//     let buttonCarrito = document.getElementById("buttonCarrito")
//     buttonCarrito.addEventListener("click", ()=>{
//         let currentProductos = productos.map((producto)=>{
//             carritoProductos.push(producto.id)
//             console.log(carritoProductos)
//         })
//     })
// }
