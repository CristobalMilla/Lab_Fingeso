<template>
    <footer>
      <p>© 2024 AutoAltiro. Todos los derechos reservados.</p>
    </footer>
  </template>
  
  <script>
  export default {
    name: 'Footer',
  };
  </script>
  
  <style scoped>
  footer {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 0; 
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    box-sizing: border-box; 
    z-index: 10;
  }
  </style>
  