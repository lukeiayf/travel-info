<template>
    <div class="bg-white shadow rounded-xl">
            <RouterLink :to="{ name: 'mealDetails', params: { id: meal.idMeal } }">
                <img :src="meal.strMealThumb" :alt="meal.strMeal" class="rounded-t-xl w-full h-48 object-cover">
            </RouterLink>
            <div class="p-3">
                <h3 class="font-bold">{{ meal.strMeal }}</h3>
                <p class="mb-4">{{ instructions }}</p>
                <div class="flex items-center justify-between">
                   <YoutubeButton :href="meal.strYoutube">YouTube</YoutubeButton>
                </div>
            </div>
        </div>
</template>
<script setup>
import { computed } from 'vue';
import YoutubeButton from '../components/YoutubeButton.vue';

const { meal } = defineProps({
    meal:Object
})

const instructions = computed(() => {
    const limit = 100; 
      if (meal.strInstructions.length > limit) {
        return meal.strInstructions.substring(0, limit) + '...';
      } else {
        return meal.strInstructions;
      }
})

</script>