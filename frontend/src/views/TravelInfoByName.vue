<template>
    <div class="p-8 pb-0">
        <input type="text" v-model="keyWord" class="rounded border-2 bg-white border-gray-200 w-full"
            placeholder="Search for meals" @change="searchMeals" />

    </div>
     <TravelInfo :travelInfo="travelInfo" />
</template>

<script setup>
import { computed, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import TravelInfo from '../components/TravelInfo.vue';
import store from '../store';


const route = useRoute();
const keyWord = ref('');
const travelInfo = computed(() => store.state.travelInfo)

function searchMeals() {
    if (keyWord.value) {
        store.dispatch('searchTravelInfo', keyWord.value);
    } else {
        store.commit('setTravelInfo', []);
    }
}

onMounted(() => {
    keyWord.value = route.params.name
    if (keyWord.value) {
        searchMeals();
    }
})
</script>