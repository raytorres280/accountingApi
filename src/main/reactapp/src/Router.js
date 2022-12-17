import * as React from 'react';
import {
    createBrowserRouter,
    createRoutesFromElements,
    Route,
    RouterProvider,
    BrowserRouter
} from "react-router-dom";
import Layout from './Layout';
import ExamplePage from './ExamplePage';
  
const router = createBrowserRouter(
    createRoutesFromElements(
        <Route path="/" element={<ExamplePage />}>
            <Route path="dashboard" element={<p>hello</p>} />
            <Route path="dashboard" element={<p>hello</p>} />
            {/* ... etc. */}
        </Route>
    )
);

export default function Router() {
    return (
        <BrowserRouter>
            <Layout />
        </BrowserRouter>
    )
}
  
