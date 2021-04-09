let productosContainer = document.getElementById("productos")
let id = document.getElementById("id") 
let nombre = document.getElementById("nombre") 
let precio = document.getElementById("precio") 
let descripcion = document.getElementById("descripcion") 
let imagen = document.getElementById("imagen") 
let cantidad = document.getElementById("cantidad") 
let categoria = document.getElementById("categoria") 
let unidad = document.getElementById("unidad") 
let enviarBoton = document.getElementById("enviarBoton")

let idEditar = document.getElementById("id-editar") 
let nombreEditar = document.getElementById("nombre-editar") 
let precioEditar = document.getElementById("precio-editar") 
let descripcionEditar = document.getElementById("descripcion-editar") 
let imagenEditar = document.getElementById("imagen-editar") 
let cantidadEditar = document.getElementById("cantidad-editar") 
let categoriaEditar = document.getElementById("categoria-editar") 
let unidadEditar = document.getElementById("unidad-editar") 
let editarBoton = document.getElementById("editarBoton")
let eliminarForm = document.getElementById("eliminarForm")
let eliminarDiv = document.getElementById("eliminarDiv")


let productos = []

// Obteniendo los productos de la API
const getProductos = () => {
    // axios.get('http://localhost:8080/getProductos')
    axios.get('http://localhost:18090/api/v1/producto')
    .then(response => {
        const respuestaProductos = response.data;
        console.log(`GET respuestaProductos`, respuestaProductos);
        productos = respuestaProductos
        render();
        let buttonEditar = document.getElementById("buttonEditar")
        let buttonEliminar = document.getElementById("buttonEliminar")
    })
     .catch(error => console.error(error));
    };
getProductos();

// Haciendo render en pantalla de los productos obtenidos
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
                <div>
                <div class="buttonsContainer">
                    <a class="btn btn-outline-success" href="#formEditar" id="buttonEditar">Editar<span class="icon-pencil"></span></a>
                    <button class="btn btn-outline-success" id="buttonEliminar">Eliminar<span class="icon-bin"></span></button>
                </div>
                </div></ul>`
            }).join("")
            productosContainer.innerHTML = productosRender
        }
    }
}

// Funcion para llenar el formulario de editar
function llenarFormulario(params) {
    for (let i = 0; i < buttonEditar.length; i++) {
        buttonEditar[i].addEventListener("click",()=>{
            idEditar.value = productos[i].id
            nombreEditar.value = productos[i].nombre
            precioEditar.value = productos[i].precio
            descripcionEditar.value = productos[i].descripcion
            imagenEditar.value = productos[i].imagen
            cantidadEditar.value = productos[i].cantidad
            categoriaEditar.value = productos[i].agrupacion.agrupacion
            unidadEditar.value = productos[i].unidad.unidad
        })
    }
    idEditar.readOnly = true
}
setTimeout(llenarFormulario,1000)

// Funcion para editar un producto
function editarProducto() {

    let isUrl = /(http|https|ftp|ftps)\:\/\/[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,3}(\/\S*)?/
    let isImg = /.*(png|jpg|jpeg|gif)?dl=0$/

    if(nombreEditar.value == "" || precioEditar.value == "" || descripcionEditar.value == "" || imagenEditar.value == "" || cantidadEditar.value == "" || categoriaEditar.value == "" || unidadEditar.value == ""){
        alert("Por favor revise que todos los campos estan completos.")
    }

    else if(isNaN(precioEditar.value)){
        alert("Por favor ingrese un número entero como precio.")
    }

    else if(descripcionEditar.value.length > 70) {
        alert("No se permiten descripciones con mas de 70 caracteres.")
    }

    else if(!isUrl.test(imagenEditar.value) || !isImg.test(imagenEditar.value)){
        alert("La url ingresada no corresponde a una imagen")
    }

    else if(isNaN(cantidadEditar.value)){
        alert("Por favor ingrese un número entero como cantidad.")
    }
    else if(cantidadEditar.value < 0){
        alert("Por favor ingrese una cantidad positiva.")
    }

    else{
        axios({
            method: 'put',
            url: 'http://localhost:18090/api/v1/producto',
            data: {
                id:idEditar.value,
                nombre:nombreEditar.value,
                precio:precioEditar.value,
                cantidad:cantidadEditar.value,
                descripcion:descripcionEditar.value,
                imagen:imagenEditar.value,
                unidad:{"id":getUnidad(unidadEditar.value),"unidad":unidadEditar.value},
                agrupacion:{"id":getCategoria(categoriaEditar.value),"agrupacion":categoriaEditar.value}
            }
        })
        location.href("#")
    }
    
}
editarBoton.onclick = editarProducto


// Funcion para añadir un producto
function enviarProducto(e) {

    e.preventDefault();
    

    // Con fetch
    // const datos = {
    //     nombre:nombre.value,
    //     precio:precio.value,
    //     descripcion:descripcion.value,
    //     unidad:{"id":getUnidad(unidad.value),"unidad":unidad.value},
    //     agrupacion:{"id":getCategoria(categoria.value),"agrupacion":categoria.value}
    // }
    // fetch("http://localhost:18090/api/v1/producto",{
    //     method:"POST",
    //     headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },

    // body: JSON.stringify(datos)
    // })
    // .then((response) => console.log(datos))
    // // .then((data)=> {
    // //     console.log("Succes ", datos)
    // // })
    // .then(respuestaJson => {
    //     console.log("respuesta json ", respuestaJson)
    // })
    // .catch((error)=>{
    //     console.log("Error ", error)
    // })

    let isUrl = /(http|https|ftp|ftps)\:\/\/[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,3}(\/\S*)?/
    let isImg = /.*(png|jpg|jpeg|gif)?dl=0$/

    if(nombre.value == "" || precio.value == "" || descripcion.value == "" || imagen.value == "" || cantidad.value == "" || categoria.value == "" || unidad.value == ""){
        alert("Por favor revise que todos los campos estan completos.")
    }
    else if(isNaN(precio.value)){
        alert("Por favor ingrese un número entero como precio.")
    }
    else if(precio.value < 0){
        alert("Por favor ingrese una precio positiva.")
    }
    else if(descripcion.value.length > 70) {
        alert("No se permiten descripciones con mas de 70 caracteres.")
    }
    else if(!isUrl.test(imagen.value) || !isImg.test(imagen.value)){
        alert("La url ingresada no corresponde a una imagen")
    }
    else if(isNaN(cantidad.value)){
        alert("Por favor ingrese un número entero como cantidad.")
    }
    else if(cantidad.value < 0){
        alert("Por favor ingrese una cantidad positiva.")
    }

    // Con axios
    else{
        axios({
            method: 'post',
            url: 'http://localhost:18090/api/v1/producto',
            data: {
                nombre:nombre.value,
                precio:precio.value,
                cantidad:cantidad.value,
                descripcion:descripcion.value,
                imagen:imagen.value,
                unidad:{"id":getUnidad(unidad.value),"unidad":unidad.value},
                agrupacion:{"id":getCategoria(categoria.value),"agrupacion":categoria.value}
            }
          });
          getProductos()
          location.replace("#")
          location.reload()
    }
}
enviarBoton.onclick = enviarProducto

// Eliminar desde el boton del formulario
function eliminarProductoForm(){
    axios.delete(`http://localhost:18090/api/v1/producto/${idEditar.value}`)
    getProductos()
    location.replace("#")
    location.reload()
}

eliminarForm.onclick = eliminarProductoForm
eliminarForm.addEventListener("click",()=>location.href("#"))

// Eliminar desde el boton del div
function eliminarProductoDiv(){

    for (let i = 0; i < buttonEliminar.length; i++) {
        buttonEliminar[i].addEventListener("click",()=>{
            console.log(`diste click en el boton ${productos[i].id}`)
            axios.delete(`http://localhost:18090/api/v1/producto/${productos[i].id}`)
            getProductos()
            location.replace("#")
            location.reload()
        })
    }

}
setTimeout(eliminarProductoDiv,1000)

// Obtner la unidad de un producto
function getUnidad(unidad) {
    let value
    if(unidad === "unidad"){
        value = 1
    }
    else {
        value = 2
    }
    return value
}

// Obtener la categoria de un produtco
function getCategoria(categoria) {
    let value
    if(categoria === "frutas"){
        value = 1
    }
    else if(categoria === "verduras"){
        value = 2
    }
    else if(categoria === "carnes"){
        value = 3
    }
    else if(categoria === "aseo"){
        value = 4
    }
    else if(categoria === "snacks"){
        value = 5
    }
    return value
}