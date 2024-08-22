<template>
    <div class="p-8 pb-0">
        <input type="text" v-model="keyWord" class="rounded border-2 bg-white border-gray-200 w-full"
            placeholder="Search for a country" @change="searchCountry" />

    </div>
    <TravelInfo :travelInfo="travelInfo" />
</template>

<script setup>
import { computed, onMounted, ref, watch } from 'vue';
import { useRoute } from 'vue-router';
import TravelInfo from '../components/TravelInfo.vue';
import store from '../store';


const route = useRoute();
const keyWord = ref('');
const travelInfo = computed(() => store.state.travelInfo.items)

function searchCountry() {
    if (keyWord.value) {
        store.dispatch('searchTravelInfo', { country: keyWord.value, page: 0 });
        store.dispatch('updateCountry', keyWord.value);
    } else {
        store.commit('setTravelInfo', []);
    }
}

onMounted(() => {
    keyWord.value = route.params.name
    if (keyWord.value) {
        searchCountry();
    }
})

watch(keyWord, (newVal, oldVal) => {
  if (newVal !== oldVal) {
    searchCountry();
  }
});
</script>