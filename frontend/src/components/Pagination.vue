<template>
  <div v-if="totalItems > 1" class="flex items-center justify-between border-t border-gray-200 bg-white px-4 py-3 sm:px-6">
    <div class="flex flex-1 justify-between sm:hidden">
      <a href="#"
        class="relative inline-flex items-center rounded-md border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-700 hover:bg-gray-50"
        @click.prevent="previousPage">Previous</a>
      <a href="#"
        class="relative ml-3 inline-flex items-center rounded-md border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-700 hover:bg-gray-50"
        @click.prevent="nextPage">Next</a>
    </div>
    <div class="hidden sm:flex sm:flex-1 sm:items-center sm:justify-between">
      <div>
        <p class="text-sm text-gray-700">
          Showing
          {{ ' ' }}
          <span class="font-medium">{{ startItem }}</span>
          {{ ' ' }}
          to
          {{ ' ' }}
          <span class="font-medium">{{ endItem }}</span>
          {{ ' ' }}
          of
          {{ ' ' }}
          <span class="font-medium">{{ totalItems }}</span>
          {{ ' ' }}
          results
        </p>
      </div>
      <div>
        <nav class="isolate inline-flex -space-x-px rounded-md shadow-sm" aria-label="Pagination">
          <a href="#"
            class="relative inline-flex items-center rounded-l-md px-2 py-2 text-gray-400 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0"
            @click.prevent="previousPage">
            <span class="sr-only">Previous</span>
            <ChevronLeftIcon class="h-5 w-5" aria-hidden="true" />
          </a>

          <a v-for="page in totalPages" :key="page" href="#" aria-current="page"
            :class="['relative z-10 inline-flex items-center px-4 py-2 text-sm font-semibold',
              currentPage === page - 1 ? 'bg-indigo-600 text-white' : 'text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50']" @click.prevent="goToPage(page)">
            {{ page }}
          </a>

          <a href="#"
            class="relative inline-flex items-center rounded-r-md px-2 py-2 text-gray-400 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0"
            @click.prevent="nextPage">
            <span class="sr-only">Next</span>
            <ChevronRightIcon class="h-5 w-5" aria-hidden="true" />
          </a>
        </nav>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ChevronLeftIcon, ChevronRightIcon } from '@heroicons/vue/20/solid';
import { computed, watch, ref } from 'vue';
import store from '../store';

const travelInfo = computed(() => store.state.travelInfo);
const country = computed(() => store.state.country);


const currentPage = ref(0);
const totalPages = ref(1);
const totalItems = ref(0);
const pageSize = ref(20);

const startItem = computed(() => currentPage.value * pageSize.value + 1);
const endItem = computed(() => Math.min((currentPage.value + 1) * pageSize.value, totalItems.value));

watch(travelInfo, (newTravelInfo) => {
  totalItems.value = newTravelInfo.totalItems || 0;
  totalPages.value = newTravelInfo.totalPages || 1;
  currentPage.value = newTravelInfo.currentPage || 0;
});

watch(country, (newCountry) => {
  country.value = newCountry;
});

function previousPage() {
  if (currentPage.value > 0) {
    store.dispatch('searchTravelInfo', { country: country.value, page: currentPage.value - 1 });
  }
}

function nextPage() {
  if (currentPage.value < totalPages.value - 1) {
    store.dispatch('searchTravelInfo', { country: country.value, page: currentPage.value + 1 });
  }
}

function goToPage(page) {
  if (page >= 1 && page <= totalPages.value) {
    store.dispatch('searchTravelInfo', { country: country.value, page: page - 1 });
  }
}
</script>
