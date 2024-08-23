<template>
    <div
        class="bg-white shadow rounded-xl transition duration-300 ease-in-out transform hover:-translate-y-1 hover:scale-101 hover:shadow-lg">
        <a :href="wikipediaLink" target="_blank">
            
            <img :src="`https://flagsapi.com/${countryFlag}/flat/64.png`" :alt="`Flag of ${travelInfo.destination}`"
                class="rounded-t-xl w-full h-12 object-scale-down" @error="handleImageError">
            <div class="p-3 flex flex-col justify-center items-center">
                <h3 class="font-bold">{{ travelInfo.destination }}</h3>
                <p>{{ visaRequirement }}</p>
            </div>
        </a>
    </div>
</template>
<script setup>
import { computed } from 'vue';
import { countriesIso } from '../helper/CountriesIso';

const { travelInfo } = defineProps({
    travelInfo: Object
})

const countryFlag = countriesIso[travelInfo.destination];


const visaRequirement = computed(() => {
    const limit = 3;
    if (travelInfo.requirement.length <= limit) {
        return 'Up to ' + travelInfo.requirement + ' days visa-free';
    } else {
        return travelInfo.requirement.toUpperCase();
    }
})

const wikipediaLink = computed(() => {
    const baseURL = 'https://en.wikipedia.org/wiki/';
    const destination = travelInfo.destination.replace(/\s+/g, '_');
    return `${baseURL}${destination}`;
});

function handleImageError(event) {
    event.target.class = 'rounded-t-xl w-full h-12 mt-4 object-scale-down'
    event.target.src = 'src/assets/passport.png';
}

</script>