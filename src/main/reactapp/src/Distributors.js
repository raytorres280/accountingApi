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




export default function Distributors() {
    const [ distributors, setDistributors ] = useState([])
    useEffect(() => {
        const getDistributors = async () => {
            try {
                const res = await fetch("/distributors/stats");
                console.log(res)
                const body = await res.json()
                console.log(body)
                setDistributors(body)
            } catch (error) {
                console.log(error)
            }
        }
        getDistributors()
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
                            <TableCell>Salesman Count</TableCell>
                            <TableCell>Profit % / Item</TableCell>
                            <TableCell>Total Profits</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {distributors.map((d) => (
                            <TableRow
                                key={d.id}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                {/* <TableCell component="th" scope="row">
                                    {vendor.name}
                                </TableCell> */}
                                <TableCell>{d.id}</TableCell>
                                <TableCell>{d.name}</TableCell>
                                <TableCell>{d.totalSalesmen}</TableCell>
                                <TableCell>{d.profitPercentagePerItem}</TableCell>
                                <TableCell>{d.totalProfits}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    )
}