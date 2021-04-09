let domiciliosContainer = document.getElementById("domicilios")
let fechaDomicilio = document.getElementById("fechaDomicilio")
let estadoDomicilio = document.getElementById("estadoDomicilio")
let listaProductos = document.getElementById("listaProductos")
let valorDomicilio = document.getElementById("valorDomicilio")

let domicilios = []

const getDomicilios = () => {
    // axios.get('http://localhost:8080/getProductos')
    axios.get('http://localhost:18090/api/v1/domicilio')
    .then(response => {
        const respuestaDomicilios = response.data;
        console.log(`GET respuestaDomicilios`, respuestaDomicilios);
        domicilios = respuestaDomicilios
        render();
        let verDetalle = document.getElementById("verDetalle")
        let estadoDomicilioDiv = document.getElementById("estadoDomicilioDiv")
        llenarDiv()
    })
     .catch(error => console.error(error));
    };
getDomicilios();

// Haciendo render en pantalla de los productos obtenidos
function render () {
    for (let i = 0; i < domicilios.length; i++) {
        const domiciliosRender = domicilios.map((domicilio)=>{
            return `<ul><div class="domiciliosContainer">
                <div class="contentDomicilio">
                <li class="fechaDomicilio">Fecha: ${domicilio.fecha}</li>
                <li class="estadoDomicilio">Estado: 
                    <select name="estadoDomicilio" id="estadoDomicilioDiv">
                        <option value="pendiente">Pendiente</option>
                        <option value="enviado">Enviado</option>
                        <option value="entregado">Entregado</option>
                    </select>
                </li>
                <li class="precioDomicilio">Precio: $${domicilio.valor}</li>
                </div>

                <div class="buttonsContainer">
                <a class="btn btn-outline-success" href="#detalleDomicilio" id="verDetalle">Ver detalle <span class="icon-search"></span></a>
                </div>
            </div></ul>`
        }).join("")
        domiciliosContainer.innerHTML = domiciliosRender
    }
}

function llenarDiv(){
    for (let i = 0; i < verDetalle.length; i++) {
        axios.get(`http://localhost:18090/api/v1/domicilio/detalle/${domicilios[i].id}`)
        .then(response => {
            const respuestaDomicilio = response.data;
            estadoDomicilioDiv.value = domicilios[i].estado
        })
        .catch(error => console.error(error));
    }
}

// Funcion para llenar el formulario de editar
function llenarFormulario(params) {
    for (let i = 0; i < verDetalle.length; i++) {
        verDetalle[i].addEventListener("click",()=>{
        axios.get(`http://localhost:18090/api/v1/domicilio/detalle/${domicilios[i].id}`)
        .then(response => {
            const respuestaDomicilio = response.data;
            fechaDomicilio.innerText = domicilios[i].fecha
            estadoDomicilio.value = domicilios[i].estado
            valorDomicilio.innerText = `$${domicilios[i].valor}`

            const listaProductosRender = respuestaDomicilio.productos.map((producto)=>{
                return `<tr>
                <td>${producto.nombre}</td>
                <td>${producto.cantidad}</td>
                <td>$${producto.valor}</td>
                </tr>`
            }).join("")
            
            listaProductos.innerHTML = listaProductosRender
        })
        .catch(error => console.error(error));
        })
    }
}
setTimeout(llenarFormulario,1000)
