<template>
    <div class="p-8 pb-0">
        <input type="text" v-model="keyWord" class="rounded border-2 bg-white border-gray-200 w-full"
            placeholder="Search for meals" @change="searchMeals" />

    </div>
    <Meals :meals="meals" />
</template>

<script setup>
import { computed, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import Meals from '../components/Meals.vue';
import store from '../store';


const route = useRoute();
const keyWord = ref('');
const meals = computed(() => store.state.searchedMeals)

function searchMeals() {
    if (keyWord.value) {
        store.dispatch('searchMeals', keyWord.value);
    } else {
        store.commit('setSearchedMeals', []);
    }
}

onMounted(() => {
    keyWord.value = route.params.name
    if (keyWord.value) {
        searchMeals();
    }
})
</script>