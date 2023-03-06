const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    entry: {
        main: './src/js/main.js',
    },
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, './resources/public/assets/js'),
        publicPath: 'assets/js',
    },
    devtool: false,
    plugins: [
        new HtmlWebpackPlugin({
            filename: path.resolve(__dirname, 'resources/public/default.html'),
            template: 'resources/template.html',
        }),
    ],
    watchOptions: {
        aggregateTimeout: 1000,
        poll: 3000,
        ignored: [
            '**/env',
            '**/node_modules',
            '**/resources',
            '**/src',
            '**/target',
            '**/test',
        ],
    },
};
