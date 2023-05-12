/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/clj/helloworld/views/**/*.clj"
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}

// https://github.com/tailwindlabs/tailwindcss-intellisense/issues/400
