let productosContainer = document.getElementById("productos")

let productos = []

// Obteniendo los productos de la API
const getProductos = () => {
    // axios.get('https://reqres.in/api/users')
    axios.get('http://localhost:18090/api/v1/producto')
    .then(response => {
        const respuestaProductos = response.data;
        console.log(`GET respuestaProductos`, respuestaProductos);
        productos = respuestaProductos
        render();
        let buttonCarrito = document.getElementById("buttonCarrito");
    })
     .catch(error => console.error(error));
    };
getProductos();

// Mostrando los productos obetenidos
function render () {
    for (let i = 0; i < productos.length; i++) {
        if(productos[i].cantidad > 0){
            const productosRender = productos.map((producto)=>{
                return `<ul><div class="productosContainer">
                <div class="imagenContainer">    
                    <img src="${producto.imagen}"></img>
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
        }
    }
}

// Funcion para agregar productos al carrito
function agregarCarrito () {

    for (let i = 0; i < buttonCarrito.length; i++) {
        buttonCarrito[i].addEventListener("click",()=>{
            axios({
                method: 'post',
                url: 'http://localhost:18090/api/v1/carritoCompras',
                data:{
                    producto:{
                    id:productos[i].id, 
                    nombre:productos[i].nombre,
                    precio:productos[i].precio,
                    descripcion:productos[i].descripcion,
                    imagen:productos[i].imagen,
                    unidad:{
                        id:productos[i].unidad.id,
                        unidad:productos[i].unidad.unidad
                    },
                    agrupacion:{
                        id:productos[i].unidad.id,
                        agrupacion:productos[i].agrupacion.agrupacion
                    }                   
                    },
                    cantidad:3
                }
            }) 
        })
    }
}
setTimeout(agregarCarrito, 1000)