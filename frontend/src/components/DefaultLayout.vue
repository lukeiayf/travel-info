<template>
    <nav>
        <Navbar />
    </nav>
    <main>
        <router-view />
    </main>
    <footer>
        <Pagination />
    </footer>
</template>
<script setup>
import Navbar from "../components/Navbar.vue"
import Pagination from "../components/Pagination.vue"
</script>