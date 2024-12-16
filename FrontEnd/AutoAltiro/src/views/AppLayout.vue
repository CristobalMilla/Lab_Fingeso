<template>
    <div class="app-layout">
      <!-- Menu latéral -->
      <aside class="side-menu">
        <ul>
          <li><router-link to="/">Accueil</router-link></li>
          <li><router-link to="/admin">Admin</router-link></li>
          <li><router-link to="/customer">Client</router-link></li>
          <li><router-link to="/add-car">Ajouter une voiture</router-link></li>
          <li><router-link to="/car-status">Statut voiture</router-link></li>
          <li><router-link to="/advanced-search">Recherche avancée</router-link></li>
          <li><router-link to="/reserve">Réserver</router-link></li>
        </ul>
      </aside>
  
      <!-- Contenu principal -->
      <div class="main-content">
        <router-view /> <!-- Les pages affichées ici -->
      </div>
  
      <!-- Footer -->
      <footer class="footer">
        <p>&copy; 2024 Votre Application. Tous droits réservés.</p>
      </footer>
    </div>
  </template>
  
  <script>
  export default {
    name: "AppLayout",
  };
  </script>
