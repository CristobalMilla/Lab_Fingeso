<script setup>

</script>

<template>
    <div class="modifyCar">
    <h1>Modificar un vehiculo</h1>
    <form>
      <div class="InputContainer">
        <input type="idvehiculo" v-model="vehicleId" placeholder="Ingrese el id del vehiculo">
        <input type="marca" v-model="vehicleBrand" placeholder="Ingrese la marca del vehiculo">
        <input type="modelo" v-model="vehicleModel" placeholder="Ingrese el modelo del vehiculo">
        <input type="tipo" v-model="vehicleType" placeholder="Ingrese el tipo de vehiculo">
        <input type="matricula" v-model="vehiculeNumber" placeholder="Ingrese el numero de matricula  del vehiculo">
        <input type="kilometraje" v-model="vehicleMilleage" placeholder="Ingrese el kilometraje del vehiculo">
        <input type="estado" v-model="vehicleState" placeholder="Ingrese el estado del vehiculo">
        <input type="precioBase" v-model="vehicleBasePrice" placeholder="Ingrese el precio base del vehiculo">
        <input type="categoria" v-model="vehicleCategory" placeholder="Ingrese la categoria del vehiculo">
        <input type="transmision" v-model="vehicleTransmission" placeholder="Ingrese el tipo de transmision del vehiculo">
        <input type="combustible" v-model="vehicleFuel" placeholder="Ingrese el tipo de combustible del vehiculo">
        <input type="idSucursal" v-model="sucursalId" placeholder="Ingrese el numero de Id de la sucursal">
        <button class="sessionButton" @click="modificarVehiculo">modificar vehiculo</button>
      </div>
      <div class="alsoButtons">
        <router-link to="/menuAdmin">
          <div class="alsoButton" @click="regresar">Regresar al menu anterior</div>
        </router-link>
      </div>
    </form>
  </div>
</template>


<script>
    import axios from 'axios';
    function redireccionarAPaginaAdministrador(){
        window.location.href = '/menuAdmin';
    }
    export default {
        name: 'ModifyCar',
        data(){
            return{
                brand: '',
                model: '',
                type: '',
                number: '',
                milleage: 0,
                state: '',
                basePrice: 0,
                category: '',
                transmission: '',
                fuel: '',
                photo:'',
                sucursalIds: 0,
            }
        },
        methods:{
            regresar(){
                redireccionarAPaginaAdministrador();
            },
            async modificarVehiculo(){
                //Envio de datos a backend
                if (this.vehicleBrand != "" || this.vehicleModel != "" || this.vehicleType != "" || this.vehiculeNumber != "" || this.vehicleMilleage != "" || this.vehicleState != "" || vehicleBasePrice != "" || vehicleCategory != "" || vehicleTransmission != "" || this.vehiculeFuel != "" || this.sucursalId != "") {
                    const nuevo_vehiculo = {
                        "idvehiculo": this.vehicleId,
                        "marca": this.vehicleBrand,
                        "modelo": this.vehicleModel,
                        "tipo": this.vehicleType,
                        "matricula": this.vehicleNumber,
                        "kilometraje": this.vehicleMilleage,
                        "estado": this.vehicleState,
                        "preciobase": this.vehicleBasePrice,
                        "categoria": this.vehicleCategory,
                        "transmision": this.vehicleTransmission,
                        "combustible": this.vehicleFuel,
                        "fotovehiculo": "",
                        "sucursal": {"idsucursal": this.sucursalId},
                    }
                    console.log('idvehiculo:', this.idVehiculo, typeof this.idVehiculo);
                    console.log('sucursalId:', this.sucursalId, typeof this.sucursalId);
                    try {
                        const respuesta = await axios.put(import.meta.env.VITE_BASE_URL + "api/vehiculo/actualizarVehiculo/" + this.vehicleId, nuevo_vehiculo);
                        if(respuesta.data == 1){
                            alert("Vehiculo modificado con exito");
                        }
                        if(respuesta.data == 0){
                            alert("El id de vehiculo o los atributos son incorrectos");
                        }
                        respuesta.data = 0;
                        console.log(respuesta);
                    } catch (error) {
                        alert("No se genera conexion con el servidor")
                    }           
                } else {
                    alert("Debe llenar al menos uno de los campos")
                }
            }
        }
    }
</script>

<style>

</style>