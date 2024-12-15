<script setup>
    import styles from '@/components/styles.vue';
import { defineAsyncComponent } from 'vue';
</script>


<template>
    <main>
        <div class="general">
            <div class="content">
                <img class="image" src="./media/LogoUsachNegro.png">
                <div class="header">Seleccione la opcion que desee</div>
                <div class="alsoButtons">
                    <router-link to="/flota">
                        <div class="alsoButton" @click="flota">Agregar, modificar o eliminar vehiculos de la flota</div>
                    </router-link>
                </div>
                <div class="alsoButtons">
                    <router-link to="/repepcion">
                        <div class="alsoButton" @click="recepcion">Recepcionar vehiculos / Cambiar disponibilidad</div>
                    </router-link>
                </div>
            </div>

        </div>
    </main>
</template>

<script>

    //Redireccionamiento
    //Flota
    function redireccionarAPaginaEditarFlota(){
        window.location.href = '/flota';
    }
    //Recepcion
    function redireccionarAPaginaDisponibilidad(){
        window.location.href = '/disponibilidad';
    }
    export default{
        methods:{
            flota(){
                redireccionarAPaginaEditarFlota();
            },
            recepcion(){
                redireccionarAPaginaDisponibilidad();
            }
        }
    }
    
</script>





<style>

</style>