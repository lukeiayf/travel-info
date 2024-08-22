<template>
    <header class="bg-white shadow h-16 flex items-center justify-center">

        <div class="flex items-center gap-1">
            <router-link :to="{ name: 'byName' }"
                class="inline-flex items-center transition-colors px-2 h-full hover:bg-purple-100">
                Search Travel Information for a country
            </router-link>
        </div>
    </header>
</template>
<script setup></script>