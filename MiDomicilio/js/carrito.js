let productosContainer = document.getElementById("productos")
let totalProductos = document.getElementById("totalProductos")

let productos = []

//Obteniendo los productos añadidos al carrito
const getProductos = () => {
    // axios.get('https://reqres.in/api/users')
    axios.get('http://localhost:18090/api/v1/carritoCompras')
    .then(response => {
        const respuestaProductos = response.data;
        console.log(`GET respuestaProductos`, respuestaProductos);
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
    const productosRender = productos.map((producto)=>{
        return `<ul><div class="productosContainer">
        <div class="imagenContainer">    
            <img src="../public/img/logo.png"></img>
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

//Funcion para subir la cantidad de un producto
function subirCantidadProducto() {
    for (let i = 0; i < subirCantidad.length; i++) {
        subirCantidad[i].addEventListener("click",()=>{
            productos[i].cantidad ++
            productoCantidad[i].innerHTML = productos[i].cantidad
            axios({
                method: 'put',
                url: `http://localhost:18090/api/v1/carritoCompras/${i}/${productos[i].cantidad}`,
                data:{
                    producto:{
                    id:productos[i].id, 
                    nombre:productos[i].nombre,
                    precio:productos[i].precio,
                    descripcion:productos[i].descripcion,
                    unidad:{
                        id:productos[i].unidad.id,
                        unidad:productos[i].unidad.unidad
                    },
                    agrupacion:{
                        id:productos[i].unidad.id,
                        agrupacion:productos[i].agrupacion.agrupacion
                    }                   
                    },
                    cantidad:25
                }
            })
            setTimeout(productosTotal,1000)
        })
    }
}
setTimeout(subirCantidadProducto,1000)

// //Funcion para bajar la cantidad de un producto
function bajarCantidadProducto() {
    for (let i = 0; i < bajarCantidad.length; i++) {
        bajarCantidad[i].addEventListener("click",()=>{
            productos[i].cantidad += -1
            productoCantidad[i].innerHTML = productos[i].cantidad
            axios({
                method: 'put',
                url: `http://localhost:18090/api/v1/carritoCompras/${i}/${productos[i].cantidad}`,
                data:{
                    producto:{
                    id:productos[i].id, 
                    nombre:productos[i].nombre,
                    precio:productos[i].precio,
                    descripcion:productos[i].descripcion,
                    unidad:{
                        id:productos[i].unidad.id,
                        unidad:productos[i].unidad.unidad
                    },
                    agrupacion:{
                        id:productos[i].unidad.id,
                        agrupacion:productos[i].agrupacion.agrupacion
                    }                   
                    },
                    cantidad:25
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
            console.log(`diste click en el boton ${productos[i].id}`)
            axios({
                method: 'delete',
                url: 'http://localhost:18090/api/v1/carritoCompras',
                data:{
                    producto:{
                    id:productos[i].id, 
                    nombre:productos[i].nombre,
                    precio:productos[i].precio,
                    descripcion:productos[i].descripcion,
                    unidad:{
                        id:productos[i].unidad.id,
                        unidad:productos[i].unidad.unidad
                    },
                    agrupacion:{
                        id:productos[i].unidad.id,
                        agrupacion:productos[i].agrupacion.agrupacion
                    }                   
                    },
                    cantidad:productos[i].cantidad
                }
            }) 
        })
    }

}
setTimeout(eliminarProducto,1000)

function productosTotal() {
    let total = 0
    for (let i = 0; i < productos.length; i++) {
        total += (productos[i].precio * productos[i].cantidad)
    }
    totalProductos.innerHTML = `$${total}`
}
setTimeout(productosTotal,1000)