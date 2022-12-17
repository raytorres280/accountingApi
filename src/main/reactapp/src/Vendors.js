// import React, { useEffect, useState } from "react"
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box'
import Toolbar from '@mui/material/Toolbar'
import { useEffect, useState } from 'react';




export default function Vendors() {
    const [ vendors, setVendors ] = useState([])
    useEffect(() => {
        const getVendors = async () => {
            try {
                const res = await fetch("/vendors/stats");
                console.log(res)
                const body = await res.json()
                console.log(body)
                setVendors(body)
            } catch (error) {
                console.log(error)
            }
        }
        getVendors()
    }, [])



    return (
        <Box
            component="main"
            sx={{ flexGrow: 1, bgcolor: 'background.default', p: 0 }}
        >
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell>Name</TableCell>
                            <TableCell>Distributor Count</TableCell>
                            <TableCell>Total Profits</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {vendors.map((vendor) => (
                            <TableRow
                                key={vendor.id}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                {/* <TableCell component="th" scope="row">
                                    {vendor.name}
                                </TableCell> */}
                                <TableCell>{vendor.id}</TableCell>
                                <TableCell>{vendor.name}</TableCell>
                                <TableCell>{vendor.distributorCount}</TableCell>
                                <TableCell>{vendor.totalProfits}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    )
}