<template>
    <div class="p-8">
        <h1 class="text-4xl font-bold mb-4">Ingredients</h1>
        <RouterLink :to="{ name: 'byIngredients', params: { ingredient: ingredient.strIngredient } }"
            v-for="ingredient of ingredients" :key="ingredient.idIngredient" class="block bg-white rounded p-3 mb-3 shadow">
            <h3 class="text-2xl font-bold mb-2">{{ ingredient.strIngredient }}</h3>
            <h3>{{ ingredient.strDescription }}</h3>
        </RouterLink>
    </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import axiosClient from '../axiosClient';
import { RouterLink } from 'vue-router';

const ingredients = ref([]);

onMounted(() => {
    axiosClient.get('list.php?i=list').then(({ data }) => {
        ingredients.value = data.meals;
    })
})

</script>