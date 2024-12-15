<script setup>
    
</script>

<template>
   <main>
    <div class="general">
        <div class="content">
            <img class="image" src="./media/LogoUsachNegro.png">
            <div class="header">Elija el tipo de usuario que desea utilizar</div>
            <div class="inputContainers" v-if="developer">
                <router-link to ='/desarrollador'>
                    <div class="alsoButton" @click="handleChange">Ingresar como desarrollador</div>
                </router-link>
            </div>
            <div class="inputContainers" v-if="admin">
                <router-link to ='/administrador'>
                    <div class="alsoButton" @click="handleChange">Ingresar como administrador</div>
                </router-link>
            </div>
            <div class="inputContainers" v-if="client">
                <router-link to ='/cliente'>
                    <div class="alsoButton" @click="handleChange">Ingresar como cliente</div>
                </router-link>
            </div>
            <div class="inputContainers" v-if="employer">
                <router-link to ='/empleado'>
                    <div class="alsoButton" @click="handleChange">Ingresar como empleado</div>
                </router-link>
            </div>
            <div class="headerDescription" v-else>Su usuario no tiene los permisos correctos</div>
        </div>
    </div>
   </main>
</template>


<script>
    import axios from 'axios';
    //Redireccionamientos
    
    export default{
        data(){
            return{
                developer: false,
                admin: false,
                client: false,
                employer: false,
            }
        },
        methods:{
            async permisos(){
                //Solcitud de datos backend
                const usuario = {
                    "tiposUsuario": this.perfilesDisponibles,
                };
                try {
                    const respuesta = await axios.post;
                } catch (error) {
                    
                }
            }
        }
        if(userTypes.includes("desarrollador")){
            developer = 1;
        };
        if(userTypes.includes("administrador")){
            admin = 1;
        };
        if(userTypes.includes("cliente")){
            client = 1;
        };
        if(userTypes.includes("empleado")){
            employer = 1;
        };
        
    }


</script>


<style>

</style>