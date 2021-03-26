let productosContainer = document.getElementById("productos")
let id = document.getElementById("id") 
let nombre = document.getElementById("nombre") 
let precio = document.getElementById("precio") 
let descripcion = document.getElementById("descripcion") 
let cantidad = document.getElementById("cantidad") 
let categoria = document.getElementById("categoria") 
let unidad = document.getElementById("unidad") 
let enviarBoton = document.getElementById("enviarBoton")


let productos = []


const getUsers = () => {
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
getUsers();

function render () {
    const productosRender = productos.map((producto)=>{
        return `<ul><div class="productosContainer">
        <div class="imagenContainer">    
            <img src=".${producto.imagen}"></img>
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

function enviarProducto(e) {

    e.preventDefault();
    
    const datos = {
        nombre:nombre.value,
        precio:precio.value,
        descripcion:descripcion.value,
        unidad:{"id":getUnidad(unidad.value),"unidad":unidad.value},
        agrupacion:{"id":getCategoria(categoria.value),"agrupacion":categoria.value}
    }
    fetch("http://localhost:18090/api/v1/producto",{
        method:"POST",
        headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },

    body: JSON.stringify(datos)
    })
    .then((response) => console.log(datos))
    // .then((data)=> {
    //     console.log("Succes ", datos)
    // })
    .then(respuestaJson => {
        console.log("respuesta json ", respuestaJson)
    })
    .catch((error)=>{
        console.log("Error ", error)
    })

    // e.preventDefault();
    // let data = {}
    // axios({
    //     method: 'post',
    //     url: 'http://localhost:18090/api/v1/producto',
    //     data: {
    //         nombre:"naranja",
    //         precio:3000,
    //         descripcion:"naranja por unidad",
    //         unidad:1,
    //         categoria:1
    //     }
    //   });
      
    //   console.log(data)
}


enviarBoton.onclick = enviarProducto

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

function getCategoria(categoria) {
    let value
    if(categoria === "frutas"){
        value = 1
    }
    else if(categoria === "verduras"){
        value = 2
    }
    else if(categoria === "aseo"){
        value = 3
    }
    else if(categoria === "snacks"){
        value = 4
    }
    return value
}