<template>
    <div class="bg-white shadow rounded-xl">
        <a :href="wikipediaLink" target="_blank">
            <div class="p-3">
                <h3 class="font-bold">{{ travelInfo.destination }}</h3>
                <p>{{ visaRequirement }}</p>
            </div>
        </a>
    </div>
</template>
<script setup>
import { computed } from 'vue';
import { RouterLink } from 'vue-router';

const { travelInfo } = defineProps({
    travelInfo: Object
})

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

</script>