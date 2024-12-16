<script setup>

</script>

<template>
    <main>
        <div class="general">
            <div class="content">
                <img class="image" src="./media/LogoUsachNegro.png">
                <div class="header">Inicio de sesion</div>
                <div class="headerDescription" v-if="!register">Completar campos para iniciar sesion</div>
                <div class="headerDescription" v-else>Completar campos para registro</div>
                <div class="inputContainers" v-if="!register">
                    <input type="email" v-model="username" placeholder="Ingrese correo">
                    <input type="password" v-model="password" placeholder="Ingrese contraseña">
                    <button class="sessionButton" @click="login">Iniciar Sesion</button>
                </div>
                <div class="InputContainer" v-else>
                    <input type="email" v-model="usernameRegister" placeholder="Ingrese correo">
                    <input type="password" v-model="passwordRegister" placeholder="Ingrese contraseña">
                    <input type="password" v-model="passwordRegisterConfirmation" placeholder="Ingrese contraseña nuevamente">
                    <input type="rut" v-model="rutRegister" placeholder="Ingrese rut">
                    <input type="name" v-model="nameRegister" placeholder="Ingrese su nombre">
                    <input type="age" v-model="ageRegister" placeholder="Ingrese su edad">
                    <input type="documentName" v-model="documentNameRegister" placeholder="Ingrese su numero de documento">
                    <input type="licenceNumber" v-model="licenceNumberRegister" placeholder="Ingrese su numero de licencia de conducir">
                    <button class="sessionButton" @click="addUser">Registrarse</button>
                </div>
                <div class="alsoButtons">
                    <div class="alsoButton" @click="handleChange" v-if="!register">Registrarse</div>
                    <div class="alsoButton" @click="handleChange" v-else>Iniciar Sesion</div>
                    <router-link to="/anonimo">
                        <div class="alsoButton" @click="handleChange">Ingresar sin iniciar sesion</div>
                    </router-link>
                </div>
            </div>
        </div>
    </main>
</template>


<script>

import axios from 'axios'

//Redireccionamiento
//Usuario
function redireccionarASubpaginaSeleccionTipoUsuario(){
    //CAMBIAR POR /tipoUsuario cuando se pueda
    window.location.href = '/menuAdmin';

}
//Usuario Anonimo
function redireccionarASubpaginaUsuarioAnonimo(){
    window.location.href = '/consultaFlota';
    
}

export default{
    data (){
        return{
            username: '',
            password: '',
            loggedIn: false,
            register: false,
            usernameRegister: '',
            passwordRegister: '',
            passwordRegisterConfirmation: '',
            rutRegister: '',
            nameRegister:'',
            ageRegister:'',
            documentNameRegister:'',
            licenceNumberRegister:'',

        }
    },
    methods:{
        async login(){
            //DEBUGGEO
            redireccionarASubpaginaSeleccionTipoUsuario();
            //DEBUGGEO

            //Envio de datos a backend
            const usuario = {
                "correo": this.username,
                "contrasena": this.password,
                
            };
            try {
                const respuesta = await axios.put(import.meta.env.VITE_BASE_URL + "api/usuario/login/", usuario);
                if (respuesta.data == 1){
                    localStorage.setItem('login', JSON.stringify(this.username));
                    redireccionarASubpaginaSeleccionTipoUsuario();
                }
                if(respuesta.data == 0){
                    alert("Credenciales Invalidas");
                }
                respuesta.data = 0;
                console.log(respuesta.data);

            } catch (error) {
                alert("No se genera conexion con el servidor")
            }
        },
        handleChange(){
            this.register = !this.register
            console.log(this.register)
        },
        anonimo(){
            this.username = "anonimo"
            redireccionarASubpaginaUsuarioAnonimo();
            localStorage.setItem("login", JSON.stringify(this.username));
        },
        async addUser(){
            //Envio de datos a BackEnd
            if(this.passwordRegister == this.passwordRegisterConfirmation){
                if(this.usernameRegister != "" & this.passwordRegister != "" & this.rutRegister != "" & this.nameRegister != "" & this.ageRegister != "" & this.documentNameRegister != "" & this.licenceNumberRegister != ""){
                    const nuevo_usuario = {
                        "correo": this.usernameRegister,
                        "contrasena": this.passwordRegister,
                        "rut": this.rutRegister,
                        "nombre": this.nameRegister,
                        "edad": this.ageRegister,
                        "carnet": this.documentNameRegister,
                        "licenciaconducir": this.licenceNumberRegister,
                    }
                    try {
                        const registro = await axios.post(import.meta.env.VITE_BASE_URL + "api/usuario/register", nuevo_usuario);
                        console.log(registro)
                        alert("Usuario registrado con exito")
                    } catch (error) {
                        alert("No se pudo registrar")
                    }
                }
                else{
                    alert("Faltan datos para ingresar")
                }
            }
            else{
                alert("Las contraseñas deben coincidir")
            }
        }
    }
}
</script>

<style>


</style>


