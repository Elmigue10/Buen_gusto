let productosContainer = document.getElementById("productos")
let totalProductos = document.getElementById("totalProductos")


let productos = []
let productosCarrito = []

//Obteniendo los productos añadidos al carrito
const getProductos = () => {
    // axios.get('https://reqres.in/api/users')
    axios.get('http://localhost:18090/api/v1/carritoCompras')
    .then(response => {
        const respuestaProductos = response.data;
        // console.log(`GET respuestaProductos`, respuestaProductos);
        productos = respuestaProductos
        render();
        let buttonEliminar = document.getElementById("buttonEliminar")
        let subirCantidad = document.getElementById("subirCantidad");
        let productoCantidad = document.getElementById("productoCantidad");
        let bajarCantidad = document.getElementById("bajarCantidad");
    })
     .catch(error => console.error(error));
    };
getProductos();

//Mostrando los productos del carrito
function render () {
    productosCarrito = []
    for (let i = 0; i <= 100; i++) {
            // console.log(i)
            if(productos[i]){
            productosCarrito.push(productos[i])}
            // console.log(productosCarrito)
    }
    const productosRender = productosCarrito.map((producto)=>{
        return `<ul><div class="productosContainer">
        <div class="imagenContainer">    
            <img src="${producto.imagen}"></img>
        </div>
        <div class="contentContainer">
            <li class="nombreProducto">${producto.nombre}</li>
            <li class"descripcionProducto">${producto.descripcion}</li>
            <li class="precioProducto">$${producto.precio}</li>
            <li class="cantidadProducto">Cantidad: <button id="bajarCantidad"><span class="icon-minus"></span></button> <span id="productoCantidad">${producto.cantidad}</span> <button id="subirCantidad"><span class="icon-plus"></span></button></li>
            <button class="btn btn-outline-success" id="buttonEliminar">Eliminar<span class="icon-bin"></span></button>
        <div>
        </div></ul>`
    }).join("")
    productosContainer.innerHTML = productosRender
}



// Funcion para subir la cantidad de un producto
function subirCantidadProducto() {
    for (let i = 0; i < subirCantidad.length; i++) {
        subirCantidad[i].addEventListener("click",()=>{
            productosCarrito[i].cantidad ++
            productoCantidad[i].innerHTML = productosCarrito[i].cantidad
            axios({
                method: 'put',
                url: `http://localhost:18090/api/v1/carritoCompras/1/12`,
                data:{
                    1:{
                    id:productosCarrito[i].id, 
                    nombre:"Diego care verga",
                    precio:productosCarrito[i].precio,
                    cantidad:12,
                    descripcion:productosCarrito[i].descripcion,
                    unidad:{
                        id:productosCarrito[i].unidad.id,
                        unidad:productosCarrito[i].unidad.unidad
                    },
                    agrupacion:{
                        id:productosCarrito[i].unidad.id,
                        agrupacion:productosCarrito[i].agrupacion.agrupacion
                    }                   
                    }
                }
            })
            setTimeout(productosTotal,1000)
        })
    }
}
setTimeout(subirCantidadProducto,1000)

//Funcion para bajar la cantidad de un producto
function bajarCantidadProducto() {
    for (let i = 0; i < bajarCantidad.length; i++) {
        bajarCantidad[i].addEventListener("click",()=>{
            productosCarrito[i].cantidad += -1
            productoCantidad[i].innerHTML = productosCarrito[i].cantidad
            axios({
                method: 'put',
                url: `http://localhost:18090/api/v1/carritoCompras/${i}/${productosCarrito[i].cantidad}`,
                data:{
                    producto:{
                    id:productosCarrito[i].id, 
                    nombre:productosCarrito[i].nombre,
                    precio:productosCarrito[i].precio,
                    descripcion:productosCarrito[i].descripcion,
                    unidad:{
                        id:productosCarrito[i].unidad.id,
                        unidad:productosCarrito[i].unidad.unidad
                    },
                    agrupacion:{
                        id:productosCarrito[i].unidad.id,
                        agrupacion:productosCarrito[i].agrupacion.agrupacion
                    }                   
                    },
                    cantidad:productosCarrito[i].cantidad
                }
            })
            setTimeout(productosTotal,1000)
        })
    }
}
setTimeout(bajarCantidadProducto,1000)

//Funcion para eliminar un producto del carrito
function eliminarProducto(){

    for (let i = 0; i < buttonEliminar.length; i++) {
        buttonEliminar[i].addEventListener("click",()=>{
            axios.delete(`http://localhost:18090/api/v1/carritoCompras/${productosCarrito[i].idCarritoCompras}`)
            getProductos()
            location.replace("#")
            location.reload()
        })
    }

}
setTimeout(eliminarProducto,1000)

function productosTotal() {
    let total = 0
    for (let i = 0; i < productosCarrito.length; i++) {
        total += (productosCarrito[i].precio * productosCarrito[i].cantidad)
    }
    totalProductos.innerHTML = `$${total}`
}
setTimeout(productosTotal,1000)