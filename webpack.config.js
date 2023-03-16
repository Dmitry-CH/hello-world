const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const NODE_ENV = (process.env.NODE_ENV || 'development').trim();

module.exports = {
    mode: NODE_ENV,
    entry: {
        main: './src/js/index.js',
    },
    output: {
        filename: 'js/[name].js',
        path: path.resolve(__dirname, './resources/public/assets'),
        publicPath: 'assets',
    },
    module: {
        rules: [
            {
                test: /\.css$/i,
                use: ['style-loader', 'css-loader'],
            },
        ],
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
