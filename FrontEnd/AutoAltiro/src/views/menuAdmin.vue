<script setup>
</script>


<template>
    <main>
        <div class="general"> 
            <div class="content">
                <img class="image" src="./media/LogoUsachNegro.png">
                <div class="header">Seleccione la opcion que desee</div>
                <div class="alsoButtons">
                    <div class="inputContainers" v-if="changeFlota">
                        <router-link to="/addCar">
                            <div class="alsoButton" @click="addCar">Agregar vehiculo a la flota</div>
                        </router-link>
                        <router-link to="/editCar">
                            <div class="alsoButton" @click="editCar">Modificar vehiculo en la flota</div>
                        </router-link>
                        <router-link to="/eraseCar">
                            <div class="alsoButton" @click="eraseCar">Eliminar un vehiculo en la flota</div>
                        </router-link>
                        <div class="alsoButton" @click="handleChangeFlota">Regresar</div>
                    </div>
                    <div class="inputContainers" v-else>
                        <div class="alsoButton" @click="handleChangeFlota">Agregar, modificar o eliminar vehiculos de la flota</div>
                    </div>
                </div>
                <div class="alsoButtons">
                    <router-link to="/recepcion">
                        <div class="alsoButton" @click="recepcion">Recepcionar vehiculos / Cambiar disponibilidad</div>
                    </router-link>
                </div>
            </div>
        </div>
    </main>
</template>

<script>
    //Redireccionamiento
    //Add car
    function redireccionarAPaginaAddCar(){
        window.location.href = '/add-car';
    }
    //Edit Car
    function redireccionarAPaginaModifyCar(){
        window.location.href = '/modifyCar';
    }
    //Erase Car
    function redireccionarAPaginaEraseCar(){
        window.location.href = '/eraseCar';
    }
    //Recepcion
    function redireccionarAPaginaDisponibilidad(){
        window.location.href = '/disponibilidad';
    }
    //Metodos
    export default{
        data(){
          return{
            changeFlota: false,
          }
        },
        methods:{
            addCar(){
                redireccionarAPaginaAddCar();
            },
            editCar(){
                redireccionarAPaginaModifyCar();
            },
            eraseCar(){
                redireccionarAPaginaEraseCar();
            },
            recepcion(){
                redireccionarAPaginaDisponibilidad();
            },
            handleChangeFlota(){
                this.changeFlota = !this.changeFlota
                console.log(this.register)
            }
        }
    }
    
</script>

<style>

</style>