<template>
    <Meals :meals="meals"></Meals>
</template>

<script setup>
import { computed, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import Meals from '../components/Meals.vue';
import store from '../store';

const meals = computed(() => store.state.mealsByIngredient)
const route = useRoute();

onMounted(() => {
    store.dispatch('searchMealsByIngredient', route.params.ingredient);
})
</script>