    let domiciliosContainer = document.getElementById("domicilios")
    let fechaDomicilio = document.getElementById("fechaDomicilio")
    let estadoDomicilio = document.getElementById("estadoDomicilio")
    let listaProductos = document.getElementById("listaProductos")
    let valorDomicilio = document.getElementById("valorDomicilio")

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
            setTimeout(llenarFormulario,500)
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
                    <li class"estadoDomicilio">Estado: ${domicilio.estado}</li>
                    <li class="valorDomicilio">Precio: $${domicilio.valor}</li>
                </div>
                <div class="buttonsContainer">
                    <a class="btn btn-outline-success" href="#detalleDomicilio" id="verDetalle">Ver detalle <span class="icon-search"></span></a>
                </div>
                </div></ul>`
            }).join("")
            domiciliosContainer.innerHTML = domiciliosRender
    }

    // Funcion para llenar el formulario de editar
    function llenarFormulario() {
        if(verDetalle[0]){
            for (let i = 0; i < verDetalle.length; i++) {
                verDetalle[i].addEventListener("click",()=>{
                    let listaProductosRender = null
                    console.log("usted es re gei")
                axios.get(`http://localhost:18090/api/v1/domicilio/detalle/${domicilios[i].id}`)
                .then(response => {
                    const respuestaDomicilio = response.data;
                    console.log(respuestaDomicilio)
                    
    
                    listaProductosRender = respuestaDomicilio.productos.map((producto)=>{
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
                fechaDomicilio.innerText = domicilios[i].fecha
                estadoDomicilio.innerText = domicilios[i].estado
                valorDomicilio.innerText = `$${domicilios[i].valor}`
            }
        }
        else{
            verDetalle.addEventListener("click",()=>{
            for (let i = 0; i < domicilios.length; i++) {
                    let listaProductosRender = null
                    console.log("usted es re gei")
                axios.get(`http://localhost:18090/api/v1/domicilio/detalle/${domicilios[i].id}`)
                .then(response => {
                    const respuestaDomicilio = response.data;
                    console.log(respuestaDomicilio)
                    
    
                    listaProductosRender = respuestaDomicilio.productos.map((producto)=>{
                        return `<tr>
                        <td>${producto.nombre}</td>
                        <td>${producto.cantidad}</td>
                        <td>$${producto.valor}</td>
                        </tr>`
                    }).join("")
                    
                    listaProductos.innerHTML = listaProductosRender
                })
                .catch(error => console.error(error));
                fechaDomicilio.innerText = domicilios[i].fecha
                estadoDomicilio.innerText = domicilios[i].estado
                valorDomicilio.innerText = `$${domicilios[i].valor}`
            }
            })
        }
    }

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
            estadoDomicilio.value = domicilios[0].estado
            setTimeout(llenarFormulario,500)
        })
         .catch(error => console.error(error));
    }
    
    enviadosButton.addEventListener("click",getDomiciliosEnviados)
    pendientesButton.addEventListener("click",getDomicilios)