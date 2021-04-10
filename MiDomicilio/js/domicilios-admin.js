let domiciliosContainer = document.getElementById("domicilios")
let fechaDomicilio = document.getElementById("fechaDomicilio")
let estadoDomicilio = document.getElementById("estadoDomicilio")
let listaProductos = document.getElementById("listaProductos")
let valorDomicilio = document.getElementById("valorDomicilio")
let actualizarEstadoForm = document.getElementById("actualizarEstadoForm")
let idDomicilio = document.getElementById("idDomicilio")
let pendientesButton = document.getElementById("pendientesButton")
let enviadosButton = document.getElementById("enviadosButton")
let entregadosButton = document.getElementById("entregadosButton")

let domicilios = []

const getDomicilios = () => {
    // axios.get('http://localhost:8080/getProductos')
    axios.get('http://localhost:18090/api/v1/domicilio/pendiente')
    .then(response => {
        const respuestaDomicilios = response.data;
        console.log(`GET respuestaDomicilios`, respuestaDomicilios);
        domicilios = respuestaDomicilios
        render();
        let verDetalle = document.getElementById("verDetalle")
        let actualizarEstado = document.getElementById("actualizarEstado")
        let estadoDomicilioDiv = document.getElementById("estadoDomicilioDiv")
        asignarEstado()
    })
     .catch(error => console.error(error));
    };
getDomicilios();

// Haciendo render en pantalla de los productos obtenidos
function render () {
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
                    <button class="btn btn-outline-success" id="actualizarEstado">Actualizar <span class=""></span></button>
                </div>
                </div></ul>`
    }).join("")
    domiciliosContainer.innerHTML = domiciliosRender
}

function asignarEstado(){
    for (let i = 0; i < verDetalle.length; i++) {
        estadoDomicilioDiv[i].value = domicilios[i].estado
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
            estadoDomicilio.value = domicilios[1].estado
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

function actualizarDomicilioDiv(){
    for (let i = 0; i < actualizarEstado.length; i++) {
        actualizarEstado[i].addEventListener("click",()=>{
            if(estadoDomicilioDiv[i].value == "enviado"){
                axios({
                    method: 'put',
                    url: `http://localhost:18090/api/v1/domicilio`,
                    data:{
                        id:domicilios[i].id, 
                        estado:"PENDIENTE"
                    }
                })
                getDomicilios()
                location.replace("#")
                location.reload()
            }
        })
    }
}
setTimeout(actualizarDomicilioDiv,1000)

function actualizarDomicilioForm(){
    if(estadoDomicilio.value == "enviado"){
        axios({
            method: 'put',
            url: `http://localhost:18090/api/v1/domicilio`,
            data:{
                id:idDomicilio.value, 
                estado:"PENDIENTE"
            }
        })
        getDomicilios()
        location.replace("#")
        location.reload()
    }
}
actualizarEstadoForm.onclick = actualizarDomicilioForm

function getDomiciliosEnviados(){
    axios.get('http://localhost:18090/api/v1/domicilio/enviado')
    .then(response => {
        const respuestaDomicilios = response.data;
        console.log(`GET respuestaDomicilios`, respuestaDomicilios);
        domicilios = respuestaDomicilios
        render();
        let verDetalle = document.getElementById("verDetalle")
        let actualizarEstado = document.getElementById("actualizarEstado")
        let estadoDomicilioDiv = document.getElementById("estadoDomicilioDiv")
        asignarEstado()
        estadoDomicilio.value = domicilios[0].estado
    })
     .catch(error => console.error(error));
}

enviadosButton.addEventListener("click",getDomiciliosEnviados)
pendientesButton.addEventListener("click",getDomicilios)