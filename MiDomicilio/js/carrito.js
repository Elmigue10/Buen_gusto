let productosContainer = document.getElementById("productos")
let totalProductos = document.getElementById("totalProductos")
let vaciarCarrito = document.getElementById("vaciarCarrito")
let confirmarDomicilioBtn = document.getElementById("confirmarDomicilio")

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
    for (let i = 0; i <= 200; i++) {
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
                url: `http://localhost:18090/api/v1/carritoCompras`,
                data:{
                    id:productosCarrito[i].idCarritoCompras, 
                    cantidad:productosCarrito[i].cantidad
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
                url: "http://localhost:18090/api/v1/carritoCompras",
                data:{
                    id:productosCarrito[i].idCarritoCompras, 
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

    if(buttonEliminar[0]){
        for (let i = 0; i < buttonEliminar.length; i++) {
            buttonEliminar[i].addEventListener("click",()=>{
                axios.delete(`http://localhost:18090/api/v1/carritoCompras/${productosCarrito[i].idCarritoCompras}`)
                getProductos()
                location.replace("#")
                location.reload()
            })
        }
    }
    else{
        buttonEliminar.addEventListener("click",()=>{
        for (let i = 0; i < productosCarrito.length; i++) {
                axios.delete(`http://localhost:18090/api/v1/carritoCompras/${productosCarrito[i].idCarritoCompras}`)
                getProductos()
                location.replace("#")
                location.reload()
            }
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

function limpiarCarrito() {
    if(productosCarrito[0]){
        for (let i = 0; i < buttonEliminar.length; i++) {
            axios.delete(`http://localhost:18090/api/v1/carritoCompras/${productosCarrito[i].idCarritoCompras}`)
            getProductos()
            location.replace("#")
            location.reload()
        }
    }
    else{
        alert("Su carrito esta vacio.")
    }
}
vaciarCarrito.addEventListener("click",limpiarCarrito)

function confirmarDomicilio(){
    if(productosCarrito[0]){
        axios.post("http://localhost:18090/api/v1/domicilio")
        .then(res => {
            alert("Su domicilio ha sido enviado de manera correcta.")
            productosCarrito = []
            getProductos()
            location.replace("#")
            location.reload()
        })
        .catch(e => {
            alert("Se ha presentado un error, intente más tarde.")
        })
    }
    else{
        alert("No hay productos en su carrito.")
    }
}
confirmarDomicilioBtn.addEventListener("click",confirmarDomicilio)